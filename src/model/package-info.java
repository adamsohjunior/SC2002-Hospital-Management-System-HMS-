/**
 * Contains the data models and business logic of the application.
 * <p>
 * This package includes classes representing entities such as users, 
 * patients, doctors, appointments, and medical records. It also includes 
 * logic to manage data persistence and updates across different entities.
 * </p>
 * <p>Key classes in this package:
 * <ul>
 * <li>{@link model.Administrator} - Represents an administrator who has control over inventory and staff management. </li>
 * <li>{@link model.Appointment} - Manages the details of an appointment between a doctor and a patient.</li>
 * <li>{@link model.AppointmentOutcomeRecord} - Contains the details of the outcome of the Appoinment (E.g. Diagnosis, Prescription, etc). </li>
 * <li>{@link model.Availability} - Represent a Date and Time that is able to be scheduled for an Appointment. </li>
 * <li>{@link model.Available} - Contains a list of available dates (Availability objects) and methods to manage them </li>
 * <li>{@link model.Doctor} - Represents a doctor with associated personal information, medical records, and appointment schedules.</li>
 * <li>{@link model.DoctorRating} - Contains the rating average for a Doctor. </li>
 * <li>{@link model.Inventory} - Represents a medicine and its stock. </li>
 * <li>{@link model.MedicalRecord} - Contains all the medical information of a Patient object. </li>
 * <li>{@link model.Patient} - Represents a patient with their personal information and medical records.</li>
 * <li>{@link model.Pharmacist} - Represents a pharmacist with storage of medicines and list of all appoinment outcome records to dispense medication. </li>
 * <li>{@link model.Prescription} - Represents a prescription to be dispensed. </li>
 * <li>{@link model.Rating} - Contains rating for a User</li>
 * <li>{@link model.UpdateRating} - To update a User's rating. </li>
 * <li>{@link model.User} - An abstract class representing a User of the HMS System </li>
 * 
 * </ul>
 * </p>
 *
 * @since 1.0
 * @author Song Tingfeng
 */
package model;

