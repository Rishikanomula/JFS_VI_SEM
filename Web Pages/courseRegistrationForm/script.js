let subjects = document.querySelectorAll(".subject");
let totalBox = document.getElementById("total");

subjects.forEach(item => {
    item.addEventListener("change", () => {
        let total = 0;
        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.value);
            }
        });
        totalBox.innerText="₹ " + total;
});
});

// Optional Form Validation
// document.getElementById("regForm").addEventListener("submit", function(e) {
//     e.preventDefault();
//     e.preventDefault();

//     let selectedSubjects = [];
//     let totalFee=0;

//     subjects.forEach(sub => {
//         if(sub.checked){
//             let subjectName = sub.parentElement.innerText.trim();
//             selectedSubjects.push(subjectName);
//             totalFee += parseInt(sub.value);
//         }
//     });
//     if(selectedSubjects.length === 0){
//         alert("Please select at least one subject.");
//         return;
//     }
//     let studentName = document.getElementById("name").value;
//     let message =
//         "Student Name: " + studentName + "\n\n" +
//         "Selected Subjects:\n- " + selectedSubjects.join("\n- ") + "\n\n" +
//         "Total Fee: ₹ " + totalFee;
//     alert(message);
// });

document.getElementById("regForm").addEventListener("submit", function(e) {
    e.preventDefault();

    let summaryBox = document.getElementById("summaryBox");
    summaryBox.style.display = "none"; // Hide summary by default

    let selectedSubjects = [];
    let totalFee = 0;

    subjects.forEach(sub => {
        if (sub.checked) {
            let subjectName = sub.parentElement.innerText.trim();
            selectedSubjects.push(subjectName);
            totalFee += parseInt(sub.value);
        }
    });

    // ERROR 1: No subjects selected
    if (selectedSubjects.length === 0) {
        alert("Please select at least one subject.");
        summaryBox.style.display = "none"; // Ensure summary disappears
        return;
    }

    let studentName = document.getElementById("name").value.trim();

    // ERROR 2: Name not entered
    if (studentName === "") {
        alert("Please enter the student's name.");
        summaryBox.style.display = "none"; // Ensure summary disappears
        return;
    }

    // Build summary HTML
    let summaryHTML = `
        <h3>Registration Summary</h3>
        <p><strong>Student Name:</strong> ${studentName}</p>
        <p><strong>Selected Subjects:</strong></p>
        <ul>
            ${selectedSubjects.map(sub => `<li>${sub}</li>`).join("")}
        </ul>
        <p><strong>Total Fee:</strong> ₹ ${totalFee}</p>
    `;

    // Show the summary box again
    summaryBox.innerHTML = summaryHTML;
    summaryBox.style.display = "block";
});