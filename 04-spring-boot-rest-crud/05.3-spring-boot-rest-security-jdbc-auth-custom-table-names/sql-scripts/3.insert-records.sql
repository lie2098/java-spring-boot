--pw test123
INSERT INTO members 
VALUES 
('john', '{bcrypt}$2a$12$YqPnvj3gkkQ1zLvTAQhvKe9Pnpc1TV5Y9db0zbH4Z0S7VbasntjN2', 1),
('mary', '{bcrypt}$2a$12$OYCAURpROWIKU.ldpI2KauND9IQcRH5eBxo/WK02Of8OWyYt50ktS', 1),
('susan', '{bcrypt}$2a$12$qOMlDqGGmZwHPZa/xjKrF.vTxaqvTIAn.xufZuhc3VGksb6aksOPS', 1);

INSERT INTO roles
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');