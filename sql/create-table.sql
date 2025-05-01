-- Table: public.instructor_detail

-- DROP TABLE IF EXISTS public.instructor_detail;

CREATE TABLE IF NOT EXISTS public.instructor_detail
(
    id integer NOT NULL DEFAULT nextval('instructor_detail_id_seq'::regclass),
    youtube_channel character varying(128) COLLATE pg_catalog."default",
    hobby character varying(45) COLLATE pg_catalog."default",
    CONSTRAINT instructor_detail_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.instructor_detail
    OWNER to spring_boot_demo;

GRANT ALL ON TABLE public.instructor_detail TO spring_boot_demo;

-- Table: public.instructor

-- DROP TABLE IF EXISTS public.instructor;

CREATE TABLE IF NOT EXISTS public.instructor
(
    id integer NOT NULL DEFAULT nextval('instructor_id_seq'::regclass),
    first_name character varying(45) COLLATE pg_catalog."default",
    last_name character varying(45) COLLATE pg_catalog."default",
    email character varying(45) COLLATE pg_catalog."default",
    instructor_detail_id integer,
    CONSTRAINT instructor_pkey PRIMARY KEY (id),
    CONSTRAINT fk_instructor_detail FOREIGN KEY (instructor_detail_id)
        REFERENCES public.instructor_detail (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.instructor
    OWNER to spring_boot_demo;

GRANT ALL ON TABLE public.instructor TO spring_boot_demo;

