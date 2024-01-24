CREATE TABLE IF NOT EXISTS customer2(
	id      BIGSERIAL       PRIMARY KEY,
    name    VARCHAR(250)    NOT NULL,
    phone   VARCHAR(250),
    address VARCHAR(250),
    created timestamp       DEFAULT now()
);