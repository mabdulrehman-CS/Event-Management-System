# Event Management System (OOP)

## Overview
A comprehensive Event Management System built using Java with Object-Oriented Programming principles. This system allows users to manage university events and stalls with a sophisticated three-tier access control system. The application provides seamless workflow from request submission to approval and public visibility.

## Features

### 🔐 Three Access Levels:

#### 1. **Admin Side** - Complete Control
- Secure sign-up with security key (1.1)
- Credential-based login with 3-attempt limit
- Review all pending event and stall requests
- Approve or reject requests with one click
- Manage event decorations
- View complete request history
- Access to all system functionalities

#### 2. **User Side** - Request Management
- Submit new event requests with full details:
  - Society information
  - Event name, venue, date, and time
  - Multiple organizer details
  - Decoration requirements
- Submit stall requests with:
  - Student information
  - Stall type and name
  - Duration (start and end dates)
- Track request status in real-time
- View all personal submissions
- Check approval/rejection status

#### 3. **Public Side** - Information Access
- Browse all approved events
- View approved stall information
- Access event details (venue, timing, organizers)
- See stall details and duration
- Read-only access to public information

## How It Works

### System Workflow:

```
1. User Submits Request → 2. Saved to File → 3. Admin Reviews → 4. Approve/Reject → 5. Public Viewing
```

### Detailed Process:

**Step 1: Request Submission (User Side)**
- User navigates to User Side menu
- Selects event or stall request option
- Fills in all required details
- System validates input
- Request serialized and saved to file (Event.txt or Stall.txt)
- Status set to "pending"

**Step 2: Admin Authentication**
- Admin logs in with credentials
- Security key validation (1.1)
- Password verification (3 attempts max)
- Session established

**Step 3: Request Review (Admin Side)**
- Admin views pending requests
- Reviews all submitted details
- Makes approval decision
- System updates request status
- Changes persisted to file

**Step 4: Public Access**
- Only approved items visible
- Public browses events/stalls
- Complete information displayed
- No modification allowed

### Data Persistence:
- **Event.txt** - Stores all event objects
- **Stall.txt** - Stores all stall objects
- **SecurityPassward.txt** - Stores admin credentials
- **Variables.txt** - Stores system variables (counters, IDs)
- Java Object Serialization for data integrity

## System Requirements
- **JDK**: Java Development Kit 8 or higher
- **OS**: Windows/Linux/Mac
- **Memory**: Minimum 512 MB RAM
- **Storage**: 50 MB free space

## Installation & Setup

### Step 1: Clone Repository
```bash
git clone https://github.com/mabdulrehman-CS/Event-Management-System.git
cd Event-Management-System
```

### Step 2: Compile
```bash
javac *.java
```

### Step 3: Run
```bash
java Main
```

## Usage Guide

### First-Time Setup:

#### Admin Account Creation
1. Launch application: `java Main`
2. Select **1** (Admin Side)
3. Select **1** (Sign Up)
4. Enter Security Key: **1.1**
5. Provide admin details:
   - Full Name
   - Phone Number
   - CNIC
   - Gmail
   - Password
6. Account created successfully

#### Submitting Event Request
1. Main Menu → **2** (User Side)
2. Select **1** (Request Event)
3. Enter Details:
   - Society Name
   - Society Head Name
   - Event Name
   - Venue
   - Event Date (format: DD/MM/YYYY)
   - Event Time
   - Number of Organizers
   - For each organizer:
     - Name
     - Phone Number
     - Designation
   - Decoration Requests (optional)
4. Request submitted → Status: Pending

#### Submitting Stall Request
1. Main Menu → **2** (User Side)
2. Select **2** (Request Stall)
3. Enter Details:
   - Student Name
   - Student Department
   - Student Semester
   - Stall Name
   - Starting Date
   - Ending Date
4. Request submitted → Status: Pending

#### Admin Approval Process
1. Main Menu → **1** (Admin Side)
2. Select **2** (Login)
3. Enter credentials
4. After login, choose:
   - **1**: View Event Requests
   - **2**: View Stall Requests
   - **3**: Approve/Reject Events
   - **4**: Approve/Reject Stalls
5. Select request number
6. Choose action (Approve/Reject)
7. Status updated immediately

#### Checking Request Status
1. Main Menu → **2** (User Side)
2. Select **3** (Check Status)
3. View all your requests with current status

#### Public Viewing
1. Main Menu → **3** (Public Side)
2. Options:
   - **1**: View Approved Events
   - **2**: View Approved Stalls
3. Browse complete information

### Menu Navigation:
- **0** - Go back to previous menu
- **1-4** - Select menu options
- Follow on-screen prompts

## Object-Oriented Design Principles

### 1. **Inheritance**
- `Stall extends Student` - Inherits student properties
- `Event extends Society` - Inherits society properties
- Promotes code reusability

### 2. **Encapsulation**
- Private fields with public getters/setters
- Data hiding and protection
- Controlled access to attributes

### 3. **Serialization**
- Implements `Serializable` interface
- Persistent data storage
- Object state preservation

### 4. **Polymorphism**
- Method overriding
- Dynamic method dispatch
- Flexible code structure

### 5. **Abstraction**
- Clear separation of concerns
- Interface-based design
- Implementation hiding

## Key Functionalities

### Event Management:
✅ Create event with complete details  
✅ Add multiple organizers per event  
✅ Request decorations  
✅ Track event status  
✅ Approve/reject events  
✅ View all events (admin/public)  
✅ Automatic ID generation  

### Stall Management:
✅ Create stall requests  
✅ Associate with student information  
✅ Set duration (start/end dates)  
✅ Track stall status  
✅ Approve/reject stalls  
✅ View approved stalls publicly  
✅ Automatic ID generation  

### Security Features:
✅ Password-protected admin access  
✅ Security key verification (1.1)  
✅ Limited login attempts (3 max)  
✅ Session management  
✅ Credential encryption  
✅ Secure sign-up process  

### Data Management:
✅ File-based persistence  
✅ Object serialization  
✅ Automatic data saving  
✅ Data retrieval on startup  
✅ Error handling for file operations  

### File Structure:
```
Event Management System (OOP)/
├── Main.java           # Application entry point
├── Event.java          # Event entity class
├── Stall.java          # Stall entity class
├── Security.java       # Authentication class
├── Student.java        # Student information
├── Society.java        # Society information
├── Organizer.java      # Organizer details
├── Decoration.java     # Decoration management
├── Example.java        # Utility class
├── Event.txt           # Event data storage
├── Stall.txt           # Stall data storage
├── SecurityPassward.txt # Admin credentials
├── Variables.txt       # System variables
└── README.md           # Documentation
```

## Error Handling

The system includes robust error handling for:
- File I/O exceptions
- Invalid user input
- Serialization errors
- Number format exceptions
- Null pointer exceptions
- Failed login attempts

---

**Note**: This system is designed for educational purposes to demonstrate OOP principles.
