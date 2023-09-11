CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

-- INSERT INTO restaurant_category (name, image) VALUES ('Pizza', '0001-category-png')
-- INSERT INTO restaurant_category (name, image) VALUES ('Sanduíche', '0002-category-png')
-- INSERT INTO restaurant_category (name, image) VALUES ('Churrasco', '0003-category-png')
-- INSERT INTO restaurant_category (name, image) VALUES ('Salada', '0004-category-png')
-- INSERT INTO restaurant_category (name, image) VALUES ('Sobremesa', '0005-category-png')
-- INSERT INTO restaurant_category (name, image) VALUES ('Japonês', '0006-category-png')