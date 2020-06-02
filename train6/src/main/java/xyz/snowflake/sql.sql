CREATE TABLE customers
(
  customerI_id char(8) primary key,
  name         char(40) default null,
  phone        char(16) default null
);

INSERT INTO customers
VALUES ('ADDIFK01', 'Frank Addinsell', '(718) 555-3911');
INSERT INTO customers
VALUES ('ALBIBB01', 'Bob Albinoni', '(213) 555-7566');
INSERT INTO customers
VALUES ('ALBRDE01', 'Dave Albrechtsberger', '(508) 555-1216');