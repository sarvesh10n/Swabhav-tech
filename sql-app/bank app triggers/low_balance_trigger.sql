DELIMITER //
DROP TRIGGER IF EXISTS CHECK_UPDATE_BALANCE //
CREATE TRIGGER CHECK_UPDATE_BALANCE BEFORE UPDATE ON BANK_MASTER
FOR EACH ROW
BEGIN
    DECLARE MSG VARCHAR(128);
    IF NEW.BALANCE < 1000 THEN
        SET MSG = CONCAT('BALANCE ERROR: Trying to insert a insufficient value in bank: ', CAST(NEW.BALANCE AS CHAR));
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = MSG;
    END IF;
END
//

DELIMITER ;


DELIMITER //
DROP TRIGGER IF EXISTS CHECK_INSERT_BALANCE //
CREATE TRIGGER CHECK_INSERT_BALANCE BEFORE INSERT ON BANK_MASTER
FOR EACH ROW
BEGIN
    DECLARE MSG VARCHAR(128);
    IF NEW.BALANCE < 1000 THEN
        SET MSG = CONCAT('BALANCE ERROR: Trying to insert a insufficient value in bank: ', CAST(NEW.BALANCE AS CHAR));
        SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = MSG;
    END IF;
END
//

DELIMITER ;