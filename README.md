java考试用参考  
test目录下的文件不用管  
.gitignore文件也不用管  
数据库表：  
```
CREATE TABLE `user` (
	`name` VARCHAR(255) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`sex` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`msg` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`grade` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`filename` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`filepath` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci'
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
```

