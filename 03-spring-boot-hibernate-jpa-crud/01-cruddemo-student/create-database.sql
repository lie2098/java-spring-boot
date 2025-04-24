-- Database: spring_boot_demo

-- DROP DATABASE IF EXISTS spring_boot_demo;

CREATE DATABASE spring_boot_demo
    WITH
    OWNER = spring_boot_demo
    ENCODING = 'UTF8'
    LC_COLLATE = 'en-US'
    LC_CTYPE = 'en-US'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

ALTER DEFAULT PRIVILEGES FOR ROLE postgres
GRANT ALL ON TABLES TO spring_boot_demo;