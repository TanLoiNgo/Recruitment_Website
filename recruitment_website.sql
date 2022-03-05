-- CREATE THE RECRUITMENT WEBSITE DATABASE
-- *******************************************

-- create the database
DROP DATABASE IF EXISTS recruitment_website;
CREATE DATABASE recruitment_website;

-- select the database
USE recruitment_website;

-- create the tables
CREATE TABLE roles (
    role_ID INT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    user_ID INT PRIMARY KEY,
    role_ID INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    registration_date DATE NOT NULL,
    user_photo VARCHAR(50),
    CONSTRAINT user_fk_role FOREIGN KEY (role_ID)
        REFERENCES roles (role_ID)
);

CREATE TABLE job_seeker (
    job_seeker_ID INT PRIMARY KEY,
    user_ID INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(12) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(50) NOT NULL,
    city VARCHAR(255) NOT NULL,
    province VARCHAR(255) NOT NULL,
    summary VARCHAR(500) NOT NULL,
    CONSTRAINT job_seeker_fk_users FOREIGN KEY (user_ID)
        REFERENCES users (user_ID)
);

CREATE TABLE education (
    education_ID INT PRIMARY KEY,
    job_seeker_ID INT NOT NULL,
    level_of_education VARCHAR(50) NOT NULL,
    major VARCHAR(50) NOT NULL,
    school_name VARCHAR(50) NOT NULL,
    school_address VARCHAR(255) NOT NULL,
    is_current_school CHAR(1) NOT NULL,
    starting_date DATE NOT NULL,
    completion_date DATE NOT NULL,
    CONSTRAINT education_fk_job_seeker FOREIGN KEY (job_seeker_ID)
        REFERENCES job_seeker (job_seeker_ID)
);

CREATE TABLE work_experience (
    work_experience_ID INT PRIMARY KEY,
    job_seeker_ID INT NOT NULL,
    work_experience_name VARCHAR(50) NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    job_location VARCHAR(255) NOT NULL,
    is_current_job CHAR(1) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
	experience_description VARCHAR(255) NOT NULL,
    CONSTRAINT workExperience_fk_job_seeker FOREIGN KEY (job_seeker_ID)
        REFERENCES job_seeker (job_seeker_ID)
);

CREATE TABLE job_seeker_skills (
    job_seeker_skill_ID INT PRIMARY KEY,
    job_seeker_ID INT NOT NULL,
    skill_name VARCHAR(50) NOT NULL,
    skill_level VARCHAR(50) NOT NULL,
    CONSTRAINT job_seeker_skills_fk_job_seeker FOREIGN KEY (job_seeker_ID)
        REFERENCES job_seeker (job_seeker_ID)
);

CREATE TABLE languages (
    language_ID INT PRIMARY KEY,
    job_seeker_ID INT NOT NULL,
    language_name VARCHAR(50) NOT NULL,
    proficiency_level VARCHAR(50) NOT NULL,
    CONSTRAINT languages_fk_job_seeker FOREIGN KEY (job_seeker_ID)
        REFERENCES job_seeker (job_seeker_ID)
);

CREATE TABLE certificates (
    certificate_ID INT PRIMARY KEY,
    job_seeker_ID INT NOT NULL,
    certificate_name VARCHAR(100) NOT NULL,
    certificate_description VARCHAR(50),
    start_date DATE,
    end_date DATE,
    CONSTRAINT certificate_fk_job_seeker FOREIGN KEY (job_seeker_ID)
        REFERENCES job_seeker (job_seeker_ID)
);

CREATE TABLE company (
    company_ID INT PRIMARY KEY,
    company_name VARCHAR(50) NOT NULL,
    company_description VARCHAR(255) NOT NULL,
    company_website VARCHAR(255) NOT NULL
);

CREATE TABLE job_type (
    job_type_ID INT PRIMARY KEY,
    job_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE workplace_type (
    workplace_type_ID INT PRIMARY KEY,
    workplace_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE job_posting (
    job_posting_ID INT PRIMARY KEY,
    user_ID INT NOT NULL,
    company_ID INT NOT NULL,
    job_type_ID INT NOT NULL,
    workplace_type_ID INT NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    job_description VARCHAR(500) NOT NULL,
    street_address VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    postal_code VARCHAR(7) NOT NULL,
    country VARCHAR(50) NOT NULL,
    job_created_date DATE NOT NULL,
    is_active CHAR(1) NOT NULL,
    experience_description VARCHAR(255) NOT NULL,
    CONSTRAINT job_posting_fk_users FOREIGN KEY (user_ID)
        REFERENCES users (user_ID),
    CONSTRAINT job_posting_fk_job_company FOREIGN KEY (company_ID)
        REFERENCES company (company_ID),
    CONSTRAINT job_posting_fk_job_type FOREIGN KEY (job_type_ID)
        REFERENCES job_type (job_type_ID),
    CONSTRAINT job_posting_fk_workplace_type FOREIGN KEY (workplace_type_ID)
        REFERENCES workplace_type (workplace_type_ID)
);

CREATE TABLE applied_job (
    applied_job_ID INT PRIMARY KEY,
    job_seeker_ID INT NOT NULL,
    job_posting_ID INT NOT NULL,
    resume_location VARCHAR(100) NOT NULL,
    action_date DATE NOT NULL,
    CONSTRAINT applied_job_fk_job_seeker FOREIGN KEY (job_seeker_ID)
        REFERENCES job_seeker (job_seeker_ID),
	CONSTRAINT applied_job_fk_job_posting FOREIGN KEY (job_posting_ID)
        REFERENCES job_posting (job_posting_ID)
);
