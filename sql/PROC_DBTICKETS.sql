CREATE PROCEDURE DB2INST1.PTICKETS (
	IN  IN_NUMTICKET    CHAR(9),
	IN  IN_DESCRIPTION  CHAR(100),
	IN  IN_EVENTDATE    CHAR(26),
	OUT OUT_SQLCODE     INTEGER,
	OUT OUT_CODE        INTEGER,
	OUT OUT_MSG         CHAR(160))
--
	COMMIT ON RETURN NO
	RESULT SET 1
--
P1: BEGIN
--
  DECLARE SQLCODE INTEGER DEFAULT 0;
  DECLARE CODRET  INTEGER DEFAULT 0;
  DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    SET CODRET = SQLCODE;
--
  INSERT INTO DBTICKETS
    (NUMTICKET
    ,DESCRIPTION
    ,EVENTDATE)
  VALUES
    (IN_NUMTICKET
    ,IN_DESCRIPTION
    ,IN_EVENTDATE);
  SET OUT_SQLCODE = CODRET;
  SET OUT_CODE = 0;
  SET OUT_MSG = 'PROCESSAMENTO FINALIZADO';
END P1;
