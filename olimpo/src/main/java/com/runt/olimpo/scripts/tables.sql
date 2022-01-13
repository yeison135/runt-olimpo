CREATE TABLE profesor
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255)          NULL,
    CONSTRAINT pk_profesor PRIMARY KEY (id)
);
CREATE TABLE estudiante
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255)          NULL,
    CONSTRAINT pk_estudiante PRIMARY KEY (id)
);
CREATE TABLE asignatura
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nombre        VARCHAR(255)          NULL,
    fk_asignatura BIGINT                NOT NULL,
    fk_profesor   BIGINT                NOT NULL,
    CONSTRAINT pk_asignatura PRIMARY KEY (id)
);

ALTER TABLE asignatura
    ADD CONSTRAINT FK_ASIGNATURA_ON_FK_ASIGNATURA FOREIGN KEY (fk_asignatura) REFERENCES asignatura (id);

ALTER TABLE asignatura
    ADD CONSTRAINT FK_ASIGNATURA_ON_FK_PROFESOR FOREIGN KEY (fk_profesor) REFERENCES profesor (id);
	
CREATE TABLE colegio
(
    id     BIGINT       NOT NULL,
    nombre VARCHAR(255) NULL,
    CONSTRAINT pk_colegio PRIMARY KEY (id)
);


CREATE TABLE curso
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    grado      INT                   NULL,
    salon      VARCHAR(255)          NULL,
    fk_colegio BIGINT                NOT NULL,
    CONSTRAINT pk_curso PRIMARY KEY (id)
);

ALTER TABLE curso
    ADD CONSTRAINT FK_CURSO_ON_FK_COLEGIO FOREIGN KEY (fk_colegio) REFERENCES colegio (id);

