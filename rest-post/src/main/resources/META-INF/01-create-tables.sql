-- CREATE DATABASE rest_post
--     WITH ENCODING 'UTF8'
--     LC_COLLATE = 'en_US.UTF-8'
--     LC_CTYPE = 'en_US.UTF-8'
--     TEMPLATE template0;
--
-- \c rest_post

CREATE TABLE users (
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    username    VARCHAR(100) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    address_street      VARCHAR(255),
    address_suite       VARCHAR(100),
    address_city        VARCHAR(100),
    address_zipcode     VARCHAR(20),
    address_geo_lat     DECIMAL(10,7),
    address_geo_lng     DECIMAL(10,7),
    phone       VARCHAR(50),
    website     VARCHAR(255),
    company_name        VARCHAR(255),
    company_catch_phrase TEXT,
    company_bs          VARCHAR(255)
);

CREATE TABLE posts (
    id      INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    title   TEXT NOT NULL,
    body    TEXT NOT NULL
);

CREATE TABLE comments (
    id      INTEGER PRIMARY KEY,
    post_id INTEGER NOT NULL REFERENCES posts(id) ON DELETE CASCADE,
    name    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL,
    body    TEXT NOT NULL
);

CREATE TABLE albums (
    id      INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    title   TEXT NOT NULL
);

CREATE TABLE photos (
    id           INTEGER PRIMARY KEY,
    album_id     INTEGER NOT NULL REFERENCES albums(id) ON DELETE CASCADE,
    title        TEXT NOT NULL,
    url          TEXT NOT NULL,
    thumbnail_url TEXT NOT NULL
);

CREATE TABLE todos (
    id        INTEGER PRIMARY KEY,
    user_id   INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    title     TEXT NOT NULL,
    completed BOOLEAN NOT NULL
);

CREATE INDEX idx_posts_user_id ON posts(user_id);
CREATE INDEX idx_comments_post_id ON comments(post_id);
CREATE INDEX idx_albums_user_id ON albums(user_id);
CREATE INDEX idx_photos_album_id ON photos(album_id);
CREATE INDEX idx_todos_user_id ON todos(user_id);
