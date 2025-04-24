-- Role: spring_boot_demo
-- DROP ROLE IF EXISTS spring_boot_demo;

CREATE ROLE spring_boot_demo WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  NOBYPASSRLS
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:Xic7Soy2tpaAG6VgFgvUIA==$x1OC7F9Awa62HeBxFUZBepNjgOaxG8y88oXEeMr6FCE=:ZitKDBRbzLIEFz9/P4nO2ifXikST7oWLGudGiX69jAQ=';

COMMENT ON ROLE spring_boot_demo IS 'this is database is for spring boot course.';