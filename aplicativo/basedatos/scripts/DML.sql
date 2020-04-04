USE demobd;

INSERT INTO personas VALUES(1,"william", 29, 'M');
INSERT INTO personas VALUES(2,"pepito", 30, 'M');
INSERT INTO personas VALUES(3,"fulana", 31, 'F');
INSERT INTO personas VALUES(4,"mengano", 32, 'M');
INSERT INTO personas VALUES(5,"mitocode", 28, 'M');

INSERT INTO preferencias VALUES(1,1,"Java");
INSERT INTO preferencias VALUES(2,1,"Javascript");
INSERT INTO preferencias VALUES(3,1,"Python");

INSERT INTO preferencias VALUES(4,2,"C++");
INSERT INTO preferencias VALUES(5,2,"Go");
INSERT INTO preferencias VALUES(6,2,"Android");

INSERT INTO preferencias VALUES(7,3,"Sql");
INSERT INTO preferencias VALUES(8,3,"Assembler");
INSERT INTO preferencias VALUES(9,3,"Jython");

INSERT INTO preferencias VALUES(10,4,"Java");
INSERT INTO preferencias VALUES(11,4,"Javascript");
INSERT INTO preferencias VALUES(12,4,"Python");

INSERT INTO preferencias VALUES(13,5,"AWS");
INSERT INTO preferencias VALUES(14,5,"FullStack");
INSERT INTO preferencias VALUES(15,5,"Docker");

COMMIT;