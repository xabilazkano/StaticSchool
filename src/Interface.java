import com.zubiri.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Interface {

	public static void main(String[] args) {
		School school = new School();
		Student student = new Student();
		Teacher teacher = new Teacher();
		Administrative admin = new Administrative();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Welcome to our school database, select one of these three");
			System.out.println("1.- Students");
			System.out.println("2.- Teachers");
			System.out.println("3.- Administratives");
			System.out.println("4.- Get counter");
			System.out.println("0.- Quit");
			if (sc.hasNextInt()) {
				switch (sc.nextInt()) {
				default:
					System.out.println("Please, enter a valid option");
					break;

				case 1:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add student");
					System.out.println("2.- Delete student");
					System.out.println("3.- Get the age of a student");
					System.out.println("4.- Check absenses of a student");
					System.out.println("5.- Get teachers");
					System.out.println("6.- Add a subject");
					System.out.println("7.- Delete a subject");
					System.out.println("8.- Order students by name");
					System.out.println("9.- Get the information of a student");
					System.out.println("10.- Get the information of all the students");
					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						default:
							System.out.println("Please, enter a valid option");
							break;

						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Age");
							int age = sc.nextInt();
							if (!Person.isAdult(age)) {
								System.out.println("You are not adult");
								break;
							}
							System.out.println("Birth Date");
							String date = sc.next();
							if (!student.isValidDate(date)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!student.isValidTelephone(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!student.isValidDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Mark average");
							double average = sc.nextDouble();
							System.out.println("Classroom");
							String classroom = sc.next();

							Student newstudent = new Student(name, date, telephone, dni, absenses, average, classroom);

							if (school.addStudent(newstudent)) {
								System.out.println("Succesfully added");
								newstudent.setStudentID(school.findStudentID(name));
							} else {
								System.out.println("An error happened");
							}

							break;

						case 2:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();

							if (school.deleteStudent(name)) {
								System.out.println("Student removed");
							} else {
								System.out.println("Student not found");
							}
							break;

						case 3:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudentID(name) != -1)
								System.out.println(school.getStudent(name).calculateAge());
							else
								System.out.println("Student not found");
							break;

						case 4:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.checkStudentAbsenses(name) != -1) {
								absenses = school.checkStudentAbsenses(name);
								if (absenses >= 10 && absenses < 20) {
									System.out.println(
											"The mark average was reduced %10. Number of absenses: " + absenses);
								} else if (absenses >= 20) {
									System.out.println(
											"The mark average was reduced %20. Number of absenses: " + absenses);
								} else {
									System.out.println(
											"The mark average was not reduced. Number of absenses: " + absenses);
								}
							} else
								System.out.println("Student not found");
							break;

						case 5:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudentID(name) != -1)
								school.getTeachersByStudent(name);
							else
								System.out.println("Student not found");
							break;

						case 6:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							String subject = sc.next();

							if (school.findStudentID(name) != -1)
								if (school.getStudent(name).addSubject(subject))
									System.out.println("Subject added");
								else
									System.out.println("Subject already added");
							else
								System.out.println("Student not found");
							break;

						case 7:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							subject = sc.next();

							if (school.findStudentID(name) != -1)
								if (school.getStudent(name).deleteSubject(subject))
									System.out.println("Subject deleted");
								else
									System.out.println("Subject not found");
							else
								System.out.println("Student not found");
							break;

						case 8:

							Object orderedStudents = (Object) school.getStudents();
							Object orderedPeople = (Object) school.orderPeople((ArrayList<Person>) orderedStudents);
							school.setStudents((ArrayList<Student>) orderedPeople);
							break;

						case 9:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println(school.getStudentInformation(name));
							break;

						case 10:
							System.out.println(school.getStudentsInformation());
							break;
						}
					} else {
						System.out.println("Please, enter a valid option");
					}
					break;

				case 2:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add a teacher");
					System.out.println("2.- Delete a teacher");
					System.out.println("3.- Get the age of a teacher");
					System.out.println("4.- Check absenses");
					System.out.println("5.- Check if he/she is tutor");
					System.out.println("6.- Add a subject");
					System.out.println("7.- Delete a subject");
					System.out.println("8.- Get students by tutor");
					System.out.println("9.- Get students by teacher");
					System.out.println("10.- Order teachers by name");
					System.out.println("11.- Get the information of a teacher");
					System.out.println("12.- Get the information of all the teachers");

					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						default:
							System.out.println("Please, enter a valid option");
							break;

						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							String date = sc.next();
							if (!teacher.isValidDate(date)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!teacher.isValidTelephone(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!teacher.isValidDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Salary");
							double salary = sc.nextDouble();
							System.out.println("Joined date");
							String joinedDate = sc.next();
							System.out.println("Tutor(write 'no' if not)");
							String tutor = sc.next();

							Teacher newTeacher = new Teacher(name, date, telephone, dni, absenses, salary, joinedDate,
									tutor);

							if (school.addTeacher(newTeacher)) {
								System.out.println("Succesfully added");
								newTeacher.setTeacherID(school.findTeacherID(name));
							} else {
								System.out.println("An error happened");
							}

							break;

						case 2:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();

							if (school.deleteTeacher(name)) {
								System.out.println("Teacher removed");
							} else {
								System.out.println("Teacher not found");
							}
							break;

						case 3:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1)
								System.out.println(school.getTeacher(name).calculateAge());
							else
								System.out.println("Teacher not found");

							break;

						case 4:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.checkTeacherAbsenses(name) != -1) {
								absenses = school.checkTeacherAbsenses(name);
								if (absenses >= 10 && absenses < 20) {
									System.out.println("The salary was reduced %10. Number of absenses: " + absenses);
								} else if (absenses >= 20) {
									System.out.println("The salary was reduced %20. Number of absenses: " + absenses);
								} else {
									System.out.println("The salary was not reduced. Number of absenses: " + absenses);
								}
							} else
								System.out.println("Teacher not found");
							break;
						case 5:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1) {
								String classroom = school.getTeacher(name).isTutor();
								if (!classroom.equals("")) {
									System.out.println("He/she is the tutor of the classroom" + classroom);
								} else {
									System.out.println("He/she is not a tutor");
								}
							} else {
								System.out.println("Teacher not found");
							}
							break;

						case 6:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							String subject = sc.next();

							if (school.findTeacherID(name) != -1)
								if (school.getTeacher(name).addSubject(subject))
									System.out.println("Subject added");
								else
									System.out.println("Subject already added");
							else
								System.out.println("Teacher not found");
							break;

						case 7:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							subject = sc.next();

							if (school.findTeacherID(name) != -1)
								if (school.getTeacher(name).deleteSubject(subject))
									System.out.println("Subject deleted");
								else
									System.out.println("Subject not found");
							else
								System.out.println("Teacher not found");
							break;

						case 8:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							school.getStudentsByTutor(name);
							break;

						case 9:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacherID(name) != -1)
								school.getStudentsByTeacher(name);
							else
								System.out.println("Teacher not found");
							break;

						case 10:
							Object orderedTeachers = (Object) school.getTeachers();
							Object orderedPeople = (Object) school.orderPeople((ArrayList<Person>) orderedTeachers);
							school.setTeachers((ArrayList<Teacher>) orderedPeople);
							break;

						case 11:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println(school.getTeacherInformation(name));
							break;

						case 12:
							System.out.println(school.getTeachersInformation());
							break;

						}

					}
					break;

				case 3:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add an administrative");
					System.out.println("2.- Delete an administrative");
					System.out.println("3.- Get the age of an administrative");
					System.out.println("4.- Check absenses");
					System.out.println("5.- Add a language");
					System.out.println("6.- Order the administratives by name");
					System.out.println("7.- Get the information of an administrative");
					System.out.println("8.- Get the information of all the administratives");

					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							String date = sc.next();
							if (!admin.isValidDate(date)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!admin.isValidTelephone(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!admin.isValidDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Salary");
							double salary = sc.nextDouble();
							System.out.println("Joined date");
							String joinedDate = sc.next();

							Administrative newAdmin = new Administrative(name, date, telephone, dni, absenses, salary,
									joinedDate);

							if (school.addAdministrative(newAdmin)) {
								System.out.println("Succesfully added");
								newAdmin.setAdministrativeID(school.findTeacherID(name));
							} else {
								System.out.println("An error happened");
							}
							break;

						case 2:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();

							if (school.deleteAdministrative(name)) {
								System.out.println("Teacher administrative");
							} else {
								System.out.println("administrative not found");
							}
							break;

						case 3:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findAdministrativeID(name) != -1)
								System.out.println(school.getAdministrative(name).calculateAge());
							else
								System.out.println("Administrative not found");
							break;

						case 4:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							if (school.checkAdministrativeAbsenses(name) != -1) {
								absenses = school.checkAdministrativeAbsenses(name);
								if (absenses >= 10 && absenses < 20) {
									System.out.println("The salary was reduced %10. Number of absenses: " + absenses);
								} else if (absenses >= 20) {
									System.out.println("The salary was reduced %20. Number of absenses: " + absenses);
								} else {
									System.out.println("The salary was not reduced. Number of absenses: " + absenses);
								}
							} else
								System.out.println("Administrative not found");
							break;
						case 5:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the language");
							String language = sc.next();
							if (school.findAdministrativeID(name) != -1)
								if (school.getAdministrative(name).addLanguage(language))
									System.out.println("Language added");
								else
									System.out.println("Language already added");
							else
								System.out.println("Administrative not found");
							break;

						case 6:
							Object orderedAdministratives = (Object) school.getAdministratives();
							Object orderedPeople = (Object) school
									.orderPeople((ArrayList<Person>) orderedAdministratives);
							school.setAdministratives((ArrayList<Administrative>) orderedPeople);
							break;

						case 7:
							System.out.println("Name of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println(school.getAdministrativeInformation(name));
							break;

						case 8:
							System.out.println(school.getAdministrativesInformation());
							break;
						}
					}

					break;

				case 4:
				System.out.println(Person.getCounter());
					break;

				case 0:
					flag = false;
					System.out.println("Bye!");
					break;

				}
			} else {
				System.out.println("Please, enter a valid option");
			}
		}
		sc.close();
	}

}