CREATE TABLE "coin".data_coin (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    nama VARCHAR(15) NOT NULL,
    harga INT DEFAULT 0,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
  );
