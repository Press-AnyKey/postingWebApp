USE unauthorized_deliveries_db;
START TRANSACTION;

CREATE TABLE IF NOT EXISTS job_title(
    id BIGINT NOT NULL,
    job_title VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS department(
    id BIGINT NOT NULL,
    department VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS application(
    id BIGINT NOT NULL,
    application VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS login(
    id BIGINT NOT NULL,
    app_account_name VARCHAR(255) NOT NULL,
    isActive BOOLEAN NOT NULL,
    job_title_id BIGINT NOT NULL,
    department_id BIGINT NOT NULL,
    application_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (job_title_id)
		REFERENCES unauthorized_deliveries_db.job_title (id)
		ON DELETE CASCADE,
	FOREIGN KEY (department_id)
		REFERENCES unauthorized_deliveries_db.department (id)
		ON DELETE CASCADE,
	FOREIGN KEY (application_id)
		REFERENCES unauthorized_deliveries_db.application (id)
		ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS posting(
    id BIGINT NOT NULL,
    mat_doc BIGINT NOT NULL,
    doc_date DATE,
    pstng_date DATE, 
    user_name VARCHAR(255) NOT NULL,
    authorized_delivery BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bUn(
    id BIGINT NOT NULL,
    bUn VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS currency(
    id BIGINT NOT NULL,
    currency VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS item(
    id BIGINT NOT NULL,
    item VARCHAR(255) NOT NULL,
    material_descriptuon VARCHAR(255) NOT NULL,
    amount_LC VARCHAR(255) NOT NULL,
	currency_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (currency_id)
		REFERENCES unauthorized_deliveries_db.currency (id)
		ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS posting_item(
    id BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    posting_id BIGINT NOT NULL,
    bUn_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (item_id)
		REFERENCES unauthorized_deliveries_db.item (id)
		ON DELETE CASCADE,
	FOREIGN KEY (posting_id)
		REFERENCES unauthorized_deliveries_db.posting (id)
		ON DELETE CASCADE,
	FOREIGN KEY (bUn_id)
		REFERENCES unauthorized_deliveries_db.bUn (id)
		ON DELETE CASCADE
);

COMMIT;