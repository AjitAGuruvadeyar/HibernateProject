package com.jsp.HibernateProject_Actor_Moviedb_ManyToMany;

import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for actor service or 2 for movie service");
		int selection=sc.nextInt();
		if(selection==1) {
			ActorService as=new ActorService();
			
			boolean rs=true;
			while(rs) {
				System.out.println("Enter the number (0 to 9 ) to perform the below operations "
						+ "\n 1:To add the actors "
						+ "\n 2:To find the actor by name "
						+ "\n 3:To find all actors by industry"
						+ "\n 4:To find all actors by movieTital"
						+ " \n 5:to find all actor between age 35-65 "
						+ "\n 6:to update actor age by acter Id \n "
						+ "7:To update all actors industry by addess "
						+ "\n 8:To delete actor by name "
						+ "\n 9:To delete all actor by movie name "
						+ "\n 0:To Exit");
				int choice=sc.nextInt();
				if(choice<10) {

					switch(choice){
					case 1:
						System.out.println("Enter actorId \n enter actorname\n enter actor age\n enter actor address\n"
								+ " enter actor industry\n enter actor natinality\n");

						as.save(sc.nextInt(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.next());
						break;
					case 2:
						System.out.println("To find actor by name. please enter name");
						as.findActorByName(sc.next());
						break;
					case 3:
						System.out.println("To find actor by industry. enter the industry name");
						as.findActorAllActorsByIndustry(sc.next());
						break;
					case 4:
						System.out.println("To find all actors by movieTital. please enter the movei tital");
						as.findAllActorsByMovieTital(sc.next());
						break;
					case 5:
						System.out.println("to find all actor between age 35-65.");
						as.findActorsBetweenAge();
						break;
					case 6:
						System.out.println("to update actor age by acter Id,enter the actor id and actor age");
						as.updateActorAgeByActorId(sc.nextInt(),sc.nextInt());
						break;
					case 7:
						System.out.println("To update all actors industry by addess, please enter the actor address and new industry");
						as.updateActorIndustryByActorAddress(sc.next(),sc.next() );
						break;
					case 8:
						System.out.println("To delete actor by name, please enter the actor name");
						as.deleteByName(sc.next());
						break;
					case 9:
						System.out.println("To delete all actor by movie name , please enter the movie name");
						as.deleteAllActorByMovie(sc.next());
						break;
					case 0:
						rs=false;
						System.out.println("thank you 😊");
					}
				}
				else {
					System.out.println("Invalid choice pleace enter valid choice");
				}
			}
		}
		else if(selection==2){
			MovieService ms=new MovieService();
			boolean rs=true;
			while(rs) {
				System.out.println("Enter the number (0 to 10) to perform the below operations "
						+ "\n 1:To add the movies "
						+ "\n 2:To find the movie by Id "
						+ "\n 3:To find movie by name"
						+ "\n 4:To find all movies by director"
						+ " \n 5:to find all movies by genre "
						+ "\n 6:to find all movies by actor name\n "
						+ "7:To update all movies by box office collection( update all movies to 'superhit' "
						+ "when boxofficeCollection is between 200cr to 500cr) "
						+ "\n 8:To delete by name "
						+ "\n 9:To delete all movies by director "
						+"\n 10:To delete all movies by actorname "
						+ "\n 0:To Exit");
				int choice=sc.nextInt();
				if(choice<10) {

					switch(choice){
					case 1:
						System.out.println("Enter movieId \n enter movieTitale \n enter movei genre\n enter directo\n"
								+ " enter box office collection\n enter box office collection verdict \n movie Language \n");

//						ms.save(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next());
						break;
					case 2:
						System.out.println("To find the movie by Id. please movie Id");
//						ms.findMovieById(sc.nextInt());
						break;
					case 3:
						System.out.println("To find movie by name. enter the movie name");
//						ms.findMovieByName(sc.next());
						break;
					case 4:
						System.out.println("To find all movies by director. please enter the director name)");
//						ms.findMovieByDirector(sc.next());
						break;
					case 5:
						System.out.println("to find all movies by genre. please enter genre");
//						ms.findMovieByGenre(sc.next());
						break;
					case 6:
						System.out.println("to find all movies by actor name,enter the actor name");
//						ms.findAllMoviesByActorName(sc.next());
						break;
					case 7:
						System.out.println("To update product price by name , please enter the product name and price");
//not getting						ms.updatePriceByName(sc.next(),sc.nextInt() );
						break;
					case 8:
						System.out.println("To delete by name, please enter the movie name");
//						ms.deleteByName(sc.next());
						break;
					case 9:
						System.out.println("To delete all movies by director ,please enter the director name");
//						ms.deleteByDirector(sc.next());
						break;
					case 10:
						System.out.println("To delete all movies by actorname ,please enter the actor name");
//						ms.deleteByActor(sc.next());
						break;
					case 0:
						rs=false;
						System.out.println("thank you 😊");

					}

				}
				else {
					System.out.println("Invalid choice pleace enter valid choice");
				}
			}
		}


	}
}
