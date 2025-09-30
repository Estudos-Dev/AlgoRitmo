CREATE TABLE IF NOT EXISTS vendedor (
    id uuid NOT NULL,
    PRIMARY KEY (id),
    nome        VARCHAR(150) NOT NULL,
    email       VARCHAR(150) UNIQUE NOT NULL,
    criado_em   TIMESTAMP DEFAULT NOW()
    );
