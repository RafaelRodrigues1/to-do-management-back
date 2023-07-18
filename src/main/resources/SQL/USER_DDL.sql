CREATE TABLE users
(
    id           char(36) NOT NULL,
    name         VARCHAR(255) NOT NULL,
    registration VARCHAR(255) NOT NULL UNIQUE,
    email        VARCHAR(100) NOT NULL UNIQUE,
    senha        VARCHAR(255) NOT NULL,
    dt_register  datetime     NOT NULL,
    status       VARCHAR(30) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

DELIMITER :)
CREATE TRIGGER TGR_SEQUENCES_INSERT BEFORE INSERT
    ON USERS
    FOR EACH ROW
BEGIN
    DECLARE RegistrationValue BIGINT;

    SELECT GetSequenceVal('USER_REGISTRATION_SEQ', 1) INTO @RegistrationValue;

    SET NEW.registration = (SELECT CAST(@RegistrationValue AS CHAR));
END :)
DELIMITER ;
