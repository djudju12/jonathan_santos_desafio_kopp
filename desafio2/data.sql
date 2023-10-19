-- Uma remessa de infração possui uma indentificação númerica, total de infrações;
-- Cada remessa possui somente uma situação que podem ser Criada, Expedida, Aceita e Não
-- Aceita;
CREATE TABLE remessa
(
    id       SERIAL PRIMARY KEY,
    situacao TEXT NOT NULL CHECK ( situacao IN ('Criada', 'Expedida', 'Aceita', 'Não Aceita') )
);

-- Cada remessa possui várias infrações e cada infração está em somente uma remessa;
-- Cada infração possui um número, data e hora, equipamento, velocidade permitida, velocidade
-- medida e valor binário para indicar se a infração é válida ou inválida;
CREATE TABLE infracao
(
    id                   SERIAL PRIMARY KEY,
    remessa_id           INT       NOT NULL,
    data_hora            TIMESTAMP NOT NULL,
    equipamento          TEXT      NOT NULL,
    velocidade_permitida INT       NOT NULL,
    velocidade_medida    INT       NOT NULL,
    valida               BOOLEAN   NOT NULL,

    CONSTRAINT fk_remessa
        FOREIGN KEY (remessa_id)
            REFERENCES remessa (id)
            ON DELETE CASCADE
);

-- 1. Monte uma busca para criação de um relatório que apresente todas as infrações com velocidade
-- medida igual ou acima de 20% da velocidade permitida. Ordenar a lista por data e hora da infração.
SELECT
    i.*,
    r.id AS remessa_id
FROM infracao i
         JOIN remessa r ON r.id = i.remessa_id
WHERE velocidade_medida >= velocidade_permitida * (1.0 + 0.2)
ORDER BY data_hora;

-- 2. Monte uma busca que para cada remessa apresente sua identificação, sua situação, o total de
-- infrações, total de infrações válidas e total de infrações inválidas. Ordenar a consulta pela situação das
-- remessas.
SELECT r.id                                      AS remessa_id,
       r.situacao                                AS situacao,
       COUNT(*)                                  AS total_infracoes,
       COUNT(*) FILTER (WHERE i.valida)          AS infracoes_validas,
       COUNT(*) FILTER (WHERE i.valida IS FALSE) AS infracoes_invalidas
FROM remessa r
         JOIN infracao i ON r.id = i.remessa_id
GROUP BY r.id, r.situacao
ORDER BY r.situacao;