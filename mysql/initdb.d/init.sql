-- データベースが存在しない場合のみ作成
CREATE DATABASE IF NOT EXISTS Todo;
USE Todo;

-- テーブルが存在しない場合のみ作成
CREATE TABLE IF NOT EXISTS users
(
    user_id      VARCHAR(255) NOT NULL,
    login TEXT NOT NULL,
    password TEXT NOT NULL,
    role TEXT NOT NULL,
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_user VARCHAR(255) NULL,
    updated_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_user VARCHAR(255) NULL,
    PRIMARY KEY (user_id)
);


-- todosテーブルの作成
CREATE TABLE IF NOT EXISTS todos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    is_completed BOOLEAN DEFAULT FALSE,
    due_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




-- サンプルtodo項目の挿入
INSERT INTO todos (title, description, is_completed, due_date) VALUES
('買い物', '牛乳、卵、パンを買う', FALSE, '2024-03-25'),
('掃除', 'リビングとキッチンを掃除する', FALSE, '2024-03-26'),
('レポート提出', '週次レポートをメールで送信する', FALSE, '2024-03-27');