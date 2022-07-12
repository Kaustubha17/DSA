class Student {
    //constructor method
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = [];
    }

    // instance method
    fullName() {
        return `Your full name is ${this.firstName} ${this.lastName}`
    }
    addScore(score) {
        this.scores.push(score)
        return this.scores
    }
    calcAvg() {
        return (this.scores.reduce((a, b) => { return a + b })) / this.scores.length
    }

    // Class Methods these are additional(utility) methods and used for class
    //  and not for a particular instance these can used as ClassName.ClassMethodName(instance 1,instance 2)
    static enrollStudents() {
        return "Enrolling Students...."
    }
}

let firstStudent = new Student("Kaustubha", "Shah")
// console.log(firstStudent.fullName())

firstStudent.addScore(99)
firstStudent.addScore(100)
console.log(firstStudent.scores)
console.log(firstStudent.calcAvg())
console.log(Student.enrollStudents())