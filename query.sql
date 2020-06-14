/* Not Boring Movies 
 * 
 * X city opened a new cinema, many people would like to go to this cinema. The cinema also gives
 * out a poster indicatng the movies' ratings and descriptions. Please write a SQL query to output
 * movies with an odd numbered ID and a description that is not "boring". Order the result by rating.
 */ 
 
 Select id, movie, description, rating from cinema where id % 2 != 0 AND description != "boring" Order by rating DESC;
 
 
