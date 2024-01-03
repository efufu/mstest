java考试用参考  
test目录下的文件不用管  
数据库表：
CREATE TABLE `student` (
	`id` INT(10) NOT NULL,
	`name` VARCHAR(255) NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
CREATE TABLE `course` (
	`id` INT(10) NOT NULL,
	`sid` INT(10) NULL DEFAULT NULL,
	`name` VARCHAR(255) NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	INDEX `sid` (`sid`) USING BTREE,
	CONSTRAINT `sid` FOREIGN KEY (`sid`) REFERENCES `student` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
