USE edu; 

CREATE OR REPLACE TABLE ex1 (
    `no`             INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`        VARCHAR(50)     NOT NULL,
    `content`    VARCHAR(255)     NULL,
    `accept`        BOOLEAN            NOT NULL DEFAULT 0,
    `regDate`    DATETIME            NOT NULL DEFAULT NOW()
);

INSERT INTO ex1 (title, content)    VALUES ('연습1','내용 추가'),('연습2','내용 없음'),('연습3','내용 수정');

COMMIT;