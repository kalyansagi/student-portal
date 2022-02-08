CREATE user studentportal WITH PASSWORD 'studentportal';


create table faculty
(
    ksu_id          varchar(255) not null
        constraint faculty_pkey
            primary key,
    email           varchar(255),
    first_name      varchar(255),
    last_name       varchar(255),
    department_name varchar(255),
    teaching_course varchar(255)
);


GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO studentportal;