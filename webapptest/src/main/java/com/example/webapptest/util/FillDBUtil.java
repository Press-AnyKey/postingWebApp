package com.example.webapptest.util;

import com.example.webapptest.model.*;
import com.example.webapptest.repository.*;
import com.example.webapptest.util.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FillDBUtil {
    @Autowired
    private CSVParser csvParser;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private BunRepository bunRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private JobTitleRepository jobTitleRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private PostingItemRepository postingItemRepository;


    public Posting createPosting(String[] csvRow) {
        Long matDoc = Long.parseLong(csvRow[0].trim());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate docDate = LocalDate.parse(csvRow[2].trim(),formatter);
        LocalDate pstingDate = LocalDate.parse(csvRow[3].trim(),formatter);
        String userName = csvRow[9].trim();
        Boolean authorizedDelivery = false;
        return  new Posting(matDoc, docDate, pstingDate, userName, authorizedDelivery);
    }

    public Item createItem(String[] csvRow){
        String materialDescription = csvRow[4].trim();
        Double amountLC = Double.parseDouble(csvRow[7].trim().replace(',', '.'));
        Currency currency = currencyRepository.findByCurrency(csvRow[8].trim());
        return new Item(materialDescription, amountLC, currency);
    }

    public PostingItem createPostingItem(String[] csvRow, Item savedItem, Posting savedPosting){
        Integer itemNum = Integer.parseInt(csvRow[1].trim());
        Integer quantity = Integer.parseInt(csvRow[5].trim());
        Bun bun = bunRepository.findByBun(csvRow[6].trim());
        return new PostingItem(itemNum,quantity, savedItem, savedPosting,bun);
    }

    public Login createLogin(String[] csvRow){
        String appAccountName = csvRow[1].trim();
        Boolean isActive = Boolean.parseBoolean(csvRow[2].trim());
        Application application = applicationRepository.findByApplication(csvRow[0].trim());
        Department department = departmentRepository.findByDepartment(csvRow[4].trim());
        JobTitle jobTitle = jobTitleRepository.findByJobTitle(csvRow[3].trim());
        return new Login(appAccountName, isActive, application, department, jobTitle);
    }

    public void fillDBFromPosting(){
        try {
            List<String[]> csv = csvParser.csvFileRead("c:\\Users\\Personal Computer\\Downloads\\postings.csv", ';');
            for(String[] arr : csv) {
                Posting posting = createPosting(arr);
                var existingPosting = postingRepository.findByMatDoc(posting.getMatDoc());
                if (existingPosting != null) {
                    posting.setId(existingPosting.getId());
                }

                Item item = createItem(arr);
                List<Login> activeAccount = loginRepository.findByAppAccountNameAndIsActive(posting.getUserName(), true);

                posting.setAuthorizedDelivery(!activeAccount.isEmpty());

                Posting savedPosting = postingRepository.save(posting);
                Item savedItem = itemRepository.save(item);

                System.out.println(savedItem);
                System.out.println(savedPosting);

                PostingItem postingItem = createPostingItem(arr, savedItem, savedPosting);
                PostingItem savedPostingItem = postingItemRepository.save(postingItem);

                System.out.println(savedPostingItem);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void fillDBFromLogins(){
        try {
            List<String[]> csv = csvParser.csvFileRead("c:\\Users\\Personal Computer\\Downloads\\logins.csv", ',');
            for(String[] arr : csv) {
                Login login = createLogin(arr);
                var existingLogins = loginRepository.findByAppAccountName(login.getAppAccountName());
                if (!existingLogins.isEmpty()) {
                    login.setId(existingLogins.get(0).getId());
                }
                Login saveLogin = loginRepository.save(login);
                System.out.println(saveLogin);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
