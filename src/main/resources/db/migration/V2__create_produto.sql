CREATE TABLE IF NOT EXISTS produto (
    id UUID PRIMARY KEY,
    nome        VARCHAR(150) NOT NULL,
    descricao   TEXT,
    preco       FLOAT ,
    estoque     INT NOT NULL DEFAULT 0,
    categoria   VARCHAR(100),
    criado_em   TIMESTAMP DEFAULT NOW(),
    atualizado_em TIMESTAMP DEFAULT NOW()
    );

CREATE TABLE IF NOT EXISTS venda (
    id            UUID PRIMARY KEY,
    vendedor_id   UUID NOT NULL,
    produto_id    UUID NOT NULL,
    quantidade    INT NOT NULL,
    valor_total   FLOAT,
    data_venda    TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_vendedor FOREIGN KEY (vendedor_id) REFERENCES vendedor(id) ON DELETE CASCADE,
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
    );