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


-- Table: public.course

-- DROP TABLE IF EXISTS public.course;

CREATE TABLE IF NOT EXISTS public.course
(
    id integer NOT NULL DEFAULT nextval('course_id_seq'::regclass),
    title character varying(128) COLLATE pg_catalog."default",
    instructor_id integer,
    CONSTRAINT course_pkey PRIMARY KEY (id),
    CONSTRAINT course_instructor_id_fkey FOREIGN KEY (instructor_id)
        REFERENCES public.instructor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.course
    OWNER to postgres;

GRANT ALL ON TABLE public.course TO spring_boot_demo;


-- Table: public.review

-- DROP TABLE IF EXISTS public.review;

CREATE TABLE IF NOT EXISTS public.review
(
    id integer NOT NULL DEFAULT nextval('review_id_seq'::regclass),
    comment character varying(256) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    course_id integer,
    CONSTRAINT review_pkey PRIMARY KEY (id),
    CONSTRAINT review_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.review
    OWNER to spring_boot_demo;

GRANT ALL ON TABLE public.review TO spring_boot_demo;


-- Table: public.course_student

-- DROP TABLE IF EXISTS public.course_student;

CREATE TABLE IF NOT EXISTS public.course_student
(
    course_id integer NOT NULL,
    student_id integer NOT NULL,
    CONSTRAINT course_student_pkey PRIMARY KEY (course_id, student_id),
    CONSTRAINT course_student_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT course_student_student_id_fkey FOREIGN KEY (student_id)
        REFERENCES public.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.course_student
    OWNER to spring_boot_demo;

GRANT ALL ON TABLE public.course_student TO spring_boot_demo;