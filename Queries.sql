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

# Write an SQL query to report all the duplicate emails. Note that it's # guaranteed that the email field is not NULL.
SELECT email AS 'Email' FROM Person GROUP BY email HAVING COUNT(email) > 1;
