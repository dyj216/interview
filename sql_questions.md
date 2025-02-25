# Database Questions

## 1. Which SQL statement lists the buyer names in the buyer table that are not contained in the invoice table?

- a)
```sql
SELECT b.name
FROM buyer b
LEFT JOIN invoice i on b.id = i.buyer_id
WHERE i.buyer_id IS NULL;
```
- b)
```sql
SELECT DISTINCT b.name
FROM buyer b
JOIN invoice i ON b.id = i.buyer_id;
```
- c)
```sql
SELECT b.name
FROM buyer b
JOIN invoice i ON b.id = i.buyer_id;
```
- d)
```sql
SELECT DISTINCT b.name
FROM buyer b
LEFT JOIN invoice i ON b.id = i.buyer_id;
```

### Correct answer: a)

## 2. Which SQL statement returns the department number with the maximum salary given to any employee?

- a) `SELECT department_id, MAX(salary) FROM employees;`
- b) `SELECT MAX(salary) FROM employees GROUP BY department_id;`
- c) `SELECT department_id, MAX(salary) FROM employees GROUP BY department_id;`
- d) `SELECT MAX(salary) FROM employees;`

### Correct answer: c)

## 3. What does the below query do?

```sql
UPDATE inv
SET inv.status_id = 
(CASE
    WHEN inv.buyer_id = 1 THEN 'In Progress'
    WHEN inv.buyer_id = 2 THEN 'New'
    ELSE 'Rejected'
END)
FROM inoices inv;
```

- a) Updates no invoices
- b) Updates all invoices for buyer 1 to 'In Progress', buyer 2's invoices to 'New' and any other buyer's invoices to
  'Rejected'
- c) Updates all invoices to 'Rejected'
- d) Throws exception

### Correct answer: d)

## 4. Which statement below is correct to insert 'Baker' as the lastname in the persons table?

- a) `INSERT INTO persons ('Baker') INTO lastname;`
- b) `INSERT INTO persons VALUES ('Baker');`
- c) `INSERT INTO persons (lastname) VALUES ('Baker')`
- d) `INSERT ('Baker') INTO persons (lastname);`

### Correct answer: c)

## 5. What is the output of the below query?

MS SQL: `SELECT SUBSTRING('123456789', CHARINDEX('b', 'abcabcabc'), 4);`

Oracle: `SELECT SUBSTR('123456789', INSTR('b', 'abcabcabc'), 4);`

- a) 6789
- b) 2345
- c) 1234
- d) 456789

### Correct answer: b)

## 6. A table my_numbers has 6 number values: 1, 2, null, 1, 1, null. Predict the output of the below query!

`SELECT COUNT(num) from my_numbers;`

- a) 6
- b) 4
- c) 3
- d) Throws exception because count function does not work with null value.

### Correct answer: b)
