/* Not Boring Movies 
 * 
 * X city opened a new cinema, many people would like to go to this cinema. The cinema also gives
 * out a poster indicatng the movies' ratings and descriptions. Please write a SQL query to output
 * movies with an odd numbered ID and a description that is not "boring". Order the result by rating.
 */ 
  SELECT id, movie, description, rating FROM cinema WHERE id % 2 != 0 AND description != "boring" ORDER BY rating DESC;

/* Big Countries 
 * 
 * A country is big if it has an area of bigger than 3 million square km or a population of more than 
 * 25 million. Write a SQL solution to output big countries' name, population and area. 
 */ 
  SELECT name, area, population FROM World WHERE area > 3000000 || population > 25000000;
 
/* Recyclable and Low Fat Products
 * 
 * Write a SQL query to find the ids of products that are both low fat and recyclable
 */
  SELECT product_d FROM Products WHERE low-fats='Y' AND recyclable='Y';
 
/* Invalid Tweets
 * 
 * Write a SQL query ti find the IDs of the invalid tweets. The tweet is invalid if the number 
 * of characters used in the content of the tweet is strictly greater than 15. Return the result
 * in any order.
 */
  SELECT tweet_id FROM Tweets WHERE LENGTH(content) > 15; 
 
/*
 * Write an SQL query to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.
 */ 
  SELECT email AS 'Email' FROM Person GROUP BY email HAVING COUNT(email) > 1;
 
/*
 * Write a SQL query to report the first name, last name, city and state of each person in the Person table. If the address
 * of a personId is not present in the Address table, report null instead.
 */
  SELECT p.firstName, p.lastName, a.city, a.state FROM Person AS p LEFT JOIN Address AS a ON p.personId = a.personId;
  
 /*
  * Write an SQL query to find the employees who earn more than their managers.
  */
   SELECT 
       name AS 'Employee'
   FROM 
       Employee AS e
   WHERE 
       e.salary > (SELECT salary FROM Employee WHERE id = e.managerId);
   
 /*
  * Write an SQL query to report all customers who never order anything.
  */
   SELECT
       c.name AS 'Customers'
   FROM 
       Customers AS c
   LEFT JOIN 
       Orders AS o
   ON
       c.id = o.customerId
   WHERE 
       o.customerId IS NULL;
       
 /*
  * Write an SQL query to report the name and bonus amount of each employee with a bonus less than 1000.
  */
   SELECT 
       e.name, 
       b.bonus
   FROM 
       Employee AS e
   LEFT JOIN 
       Bonus AS b
   ON
       e.empId = b.empdId
   WHERE 
       b.bonus < 1000 || b.bonus IS NULL;
     
 /*
  * Write an SQL query to find all the authors that viewed at least one of their own articles.
  * Return the result table sorted by id in ascending order.
  */
   SELECT DISTINCT
       author_id AS 'id'
   FROM 
       Views
   WHERE 
       author_id = viewer_id
   ORDER BY 
       author_id ASC;
