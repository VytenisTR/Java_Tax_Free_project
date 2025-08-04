CREATE TABLE IF NOT EXISTS declarations (
                              declaration_uuid UUID PRIMARY KEY,
                              declaration_date DATE NOT NULL,
                              declaration_version BIGINT NOT NULL,
                              salesman_id BIGINT,
                              customer_id BIGINT,
                              sales_document_id BIGINT,
                              intermediary_id BIGINT
);

CREATE TABLE IF NOT EXISTS salesman (
                          id BIGSERIAL PRIMARY KEY,
                          vat_payer_code VARCHAR(14) NOT NULL,
                          vat_code_issuer VARCHAR(2) NOT NULL,
                          salesman_name VARCHAR(300) NOT NULL
);

CREATE TABLE IF NOT EXISTS customer (
                           id BIGSERIAL PRIMARY KEY,
                           first_name VARCHAR(200) NOT NULL,
                           last_name VARCHAR(200) NOT NULL,
                           birthdate DATE NOT NULL,
                           personal_id_number VARCHAR(50),
                           id_issued_by VARCHAR(2),
                           identity_document_type VARCHAR(15) NOT NULL,
                           identity_document_no VARCHAR(50) NOT NULL,
                           document_issued_by VARCHAR(2) NOT NULL,
                           residential_document_type VARCHAR(15),
                           residential_document_no VARCHAR(50),
                           residential_document_issued_by VARCHAR(2),
                           residential_country VARCHAR(2),
                           residential_eu_territory VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS sales_document (
                                id BIGSERIAL PRIMARY KEY,
                                cash_register_no VARCHAR(50),
                                cash_receipt_no VARCHAR(70),
                                invoice_no VARCHAR(70),
                                sales_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
                                id BIGSERIAL PRIMARY KEY,
                                sales_document_id BIGINT REFERENCES sales_document(id),
                                product_description VARCHAR(500) NOT NULL,
                                product_quantity INT NOT NULL,
                                measurement_units VARCHAR(3),
                                measurement_units_other VARCHAR(50),
                                taxable_amount NUMERIC(16, 2) NOT NULL,
                                vat_amount NUMERIC(16, 2) NOT NULL,
                                total_amount NUMERIC(16, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS intermediary (
                              id BIGSERIAL PRIMARY KEY,
                              no_intermediary_used BOOLEAN DEFAULT FALSE,
                              intermediary_name VARCHAR(300),
                              intermediary_id_number VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS all_countries (
                               code VARCHAR(2) PRIMARY KEY,
                               name_en VARCHAR(100) NOT NULL,
                               name_lt VARCHAR(100) NOT NULL,
                               is_it_EU BOOLEAN NOT NULL,
                               does_it_have_third_territories BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS identity_document_types (
                               code VARCHAR(15) PRIMARY KEY,
                               name_en VARCHAR(100) NOT NULL,
                               name_lt VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS measurement_units (
                               code VARCHAR(15) PRIMARY KEY,
                               name_short VARCHAR(100) NOT NULL,
                               name_long VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS residential_document_types (
                               code VARCHAR(15) PRIMARY KEY,
                               name_en VARCHAR(100) NOT NULL,
                               name_lt VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                                     id BIGSERIAL PRIMARY KEY,
                                     username VARCHAR(50) UNIQUE NOT NULL,
                                     password VARCHAR(100) NOT NULL,
                                     enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
                                     id BIGSERIAL PRIMARY KEY,
                                     name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles (
                                           user_id BIGINT NOT NULL REFERENCES users(id),
                                           role_id BIGINT NOT NULL REFERENCES roles(id),
                                           PRIMARY KEY (user_id, role_id)
);

--FOREIGN KEY CONSTRAINTS
ALTER TABLE declarationse DROP CONSTRAINT IF EXISTS fk_salesman;
ALTER TABLE declarationse ADD CONSTRAINT fk_salesman FOREIGN KEY (salesman_id) REFERENCES salesman(id);
ALTER TABLE declarationse DROP CONSTRAINT IF EXISTS fk_customer;
ALTER TABLE declarationse ADD CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id);
ALTER TABLE declarationse DROP CONSTRAINT IF EXISTS fk_sales_document;
ALTER TABLE declarationse ADD CONSTRAINT fk_sales_document FOREIGN KEY (sales_document_id) REFERENCES sales_document(id);
ALTER TABLE declarationse DROP CONSTRAINT IF EXISTS fk_intermediary;
ALTER TABLE declarationse ADD CONSTRAINT fk_intermediary FOREIGN KEY (intermediary_id) REFERENCES intermediary(id);