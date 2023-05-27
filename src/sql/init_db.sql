CREATE TABLE IF NOT EXISTS worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL CHECK (LENGTH(name) > 2 AND LENGTH(name) <=100),
    birthday DATE NOT NULL CHECK (YEAR(birthday) > 1900),
    level VARCHAR(50) NOT NULL CHECK (level IN ('trainee', 'junior', 'middle', 'senior')),
    salary_for_a_month INT NOT NULL CHECK(salary_for_a_month > 100 AND salary_for_a_month < 100000)

);

CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL CHECK (LENGTH(name) > 2 AND LENGTH(name) <=1000)
);

CREATE TABLE IF NOT EXISTS project(
    id IDENTITY PRIMARY KEY,
    client_id INT,
    start_date DATE,
    finish_date DATE
);

CREATE TABLE IF NOT EXISTS project_worker(
    project_id INTEGER,
    worker_id INTEGER,
    PRIMARY KEY(project_id, worker_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY(worker_id) REFERENCES worker(id)
);