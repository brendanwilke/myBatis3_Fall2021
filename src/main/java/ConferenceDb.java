import java.util.ArrayList;
import java.util.List;

import com.domain.Author;
import com.domain.Paper;
import com.domain.Participator;
import com.domain.Reviewer;
import com.domain.Reviews;
import com.domain.Writes;
import com.service.AuthorService;
import com.service.PaperService;
import com.service.ParticipatorService;
import com.service.ReviewerService;
import com.service.ReviewsService;
import com.service.WritesService;

import java.util.Scanner;

public class ConferenceDb {

	public static void main(String[] args) {
		// Initalizations/Important Variables
		ParticipatorService partService = new ParticipatorService();
		AuthorService authorService = new AuthorService();
		ReviewerService reviewerService = new ReviewerService();
		PaperService paperService = new PaperService();
		WritesService writesService = new WritesService();
		ReviewsService reviewsService = new ReviewsService();
		
		List<Participator> partList = new ArrayList<Participator>();
		List<Reviewer> reviewerList = new ArrayList<Reviewer>();
		List<Paper> paperList = new ArrayList<Paper>();
		
		int paperID;
		
		// Scanner to be used to get user input
		Scanner scanner = new Scanner(System.in);
		
		// User selection variable
		int userChoice = 0;
		
		// Main loop
		while (userChoice != 7) {
			displayMenu(); // Display menu every time until user breaks out of loop
			System.out.print("Please make your choice: "); // Always prompt user for choice
			userChoice = scanner.nextInt(); // Get user choice
			scanner.nextLine(); // Reset scanner
			
			// Error checking
			if (userChoice < 1 || userChoice > 7) {
				System.out.println("Sorry, but you must enter a number between 1 and 7.");
				continue;
			}
			
			switch (userChoice) { // userChoice cases 1-7
				case 1: // Enter Participator Details
					System.out.print("Please enter Email : ");
					String partEmail = scanner.next();
					
					System.out.print("Please enter First Name : ");
					String partFName = scanner.next();
					
					System.out.print("Please enter Minit : ");
					String partMInit = scanner.next();
					
					System.out.print("Please enter Last Name : ");
					String partLName = scanner.next();
					
					System.out.print("Please enter Phone : ");
					String partPhone = scanner.next();
				
					System.out.print("Please enter Affiliation : ");
					String partAffiliation = scanner.next();
					
					try {
						Participator p = new Participator(partEmail, partFName, partMInit, partLName, partPhone, partAffiliation);
						partService.insertParticipator(p);	
						System.out.println("Participator Record updated successfully");
					}
					catch(Exception e) {
						if(e instanceof org.apache.ibatis.exceptions.PersistenceException) {
							System.out.println("There must not be any duplicate emails in the system.");
						}
					}
					
					break;
				
				case 2: // Enter Author Details
					System.out.println("Participators along with their Email Addresses are :");
									
					partList = partService.getPartList();
					
					for(Participator p : partList)
						System.out.println(p.getFirstname() + " (" + p.getEmail() + ")");
					
					
					System.out.print("Please enter an Author for the Conference : ");
					String authorEmail = scanner.next();
					
					try {
						Author a = new Author(authorEmail);
						authorService.insertAuthor(a);	
						System.out.println("Author Record updated successfully");
					}
					catch(Exception e) {
						System.out.println("All authors must be unique and must be a particiaptor. Referential or primary key violation.");
					}
					
					break;
					
				case 3: // Enter Reviewer Details
					System.out.println("Participators along with their Email Addresses are :");
								
					partList = partService.getPartList();
					
					for(Participator p : partList)
						System.out.println(p.getFirstname() + " (" + p.getEmail() + ")");
					
					System.out.print("Please enter a Reviewer for the Conference : ");
					String reviewerEmail = scanner.next();
					
					try {
						Reviewer r = new Reviewer(reviewerEmail);
						reviewerService.insertReviewer(r);	
						System.out.println("Inserted Reviewer Record Successfully");
					}
					catch(Exception e) {
						System.out.println("All writers must be unique and must be a particiaptor. Referential or primary key violation.");
					}
					
					break;
					
				case 4: // Enter a Paper
					
					// Get max PaperID
					paperList = paperService.getPaperList();
					
					paperID = -1;
					
					for (Paper p : paperList) {
						if (p.getPaperid() > paperID) {
							paperID = p.getPaperid();
						}
					}
					
					paperID++;
					
					System.out.print("Please enter the Paper Title : ");
					String paperTitle = scanner.nextLine();
					
					System.out.print("Please enter the file name : ");
					String paperFileName = scanner.next();
					
					// Get number of authors, loop through and add them to ArrayList to be used later
					System.out.print("Please enter the number of authors for this paper : ");
					int paperNumAuthors = scanner.nextInt();
					
					
					int numAuthor = 1;
					ArrayList<String> paperAuthors = new ArrayList<String>();
					
					scanner.nextLine();
					
					while(paperNumAuthors > 0) {
						System.out.print("Please enter the email address of author " + numAuthor + ": ");
						String curEmail = scanner.nextLine();
						
						paperAuthors.add(curEmail);
						
						paperNumAuthors--;
						numAuthor++;
					}
					
					System.out.print("Please enter the contact author email: ");
					String paperContactAuthor = scanner.next();
					scanner.nextLine();
					
					System.out.print("Please enter the abstract : ");
					String paperAbstract = scanner.nextLine(); 
					
					// Must add paper first before adding writes
					try {
						Paper p = new Paper(paperID, paperTitle, paperFileName, paperContactAuthor, paperAbstract);
						paperService.insertPaper(p);	
						System.out.println("Updated the paper record successfully with the paper id : ");
					}
					catch(Exception e) {
						System.out.println("The paper contact author must be an author. Referential key violated.");
					}
					
					// Add writes to database
					for (int i = 0; i < paperAuthors.size(); i++) {
						try {
							Writes w = new Writes(paperID, paperAuthors.get(i));
							writesService.insertWrites(w);	
							}
						catch(Exception e) {
							System.out.println("No duplicate authors of a paper. All authors must be in the database already. Referential or primary key violated.");
						}
					}
					
					break;
					
				case 5: // Assign Review Scores
					System.out.println("List of available Reviewers along with their Email Addresses\n");
					
					reviewerList = reviewerService.getReviewerList();
					
					for(Reviewer r : reviewerList)
						System.out.println("(" + r.getEmail() + ")");
					
					System.out.println("\nList of Papers along with their titles\n");
					
					paperList = paperService.getPaperList();
					
					for(Paper p : paperList)
						System.out.println(p.getTitle() + " (" + p.getPaperid() + ")");
					
					System.out.print("\nPlease enter Review Email Address : ");
					String reviewEmail = scanner.nextLine();
					
					System.out.print("Please enter PaperID : ");
					paperID = scanner.nextInt();
					
					System.out.print("Please enter techmerit : ");
					int techmerit = scanner.nextInt();
					
					System.out.print("Please enter readability : ");
					int readability = scanner.nextInt();
					
					System.out.print("Please enter originality : ");
					int originality = scanner.nextInt();
					
					System.out.print("Please enter relavance : ");
					int relavance = scanner.nextInt();
					
					System.out.print("Please enter overallrecomm : ");
					int overallRecomm = scanner.nextInt();
					
					scanner.nextLine();
					System.out.print("Please enter commentforcommittee : ");
					String commentForCommittee = scanner.nextLine();
					
					System.out.print("Please enter commentforauthor : ");
					String commentForAuthor = scanner.nextLine();
					
					try {
						Reviews r = new Reviews(reviewEmail, paperID, techmerit, readability, originality, relavance, overallRecomm, commentForCommittee, commentForAuthor);
						reviewsService.insertReview(r);	
						System.out.println("Review Score Updated Successfully");
					}
					catch(Exception e) {
						System.out.println("There must be a reviewer with the entered reviewer email. There must also be a paper with the entered paper ID. Referential or primary key violated.");
					}
					
					break;
					
				case 6: // Print the list of papers whose average overall Recommendation is more than 7
					System.out.println("The list of papers whose average overall recommendation value is more than 7 is :");
					paperList = paperService.getPaperAbove7List();
					
					try {
						for(Paper p : paperList)
							System.out.println(p.getTitle() + " (" + p.getPaperid() + ")");
						System.out.println();
					}
					catch(Exception e) {
						System.out.println("Could not display list.");
					}
		
					break;
					
				case 7: // End main loop
					break;
			}
		}
		
		scanner.close();
		
	}
	
	// Function to display menu during loop
	public static void displayMenu() {
		System.out.println("\nMenu");
		System.out.println("****************************************************");
		System.out.println("(1) Enter Participator Details");
		System.out.println("(2) Enter Author Details");
		System.out.println("(3) Enter Reviewer Details");
		System.out.println("(4) Enter a Paper");
		System.out.println("(5) Assign Review Scores");
		System.out.println("(6) Print the list of papers whose average overall Recommendation is more than 7");
		System.out.println("(7) Exit");
		System.out.println("****************************************************");
		System.out.println();
	}

}
