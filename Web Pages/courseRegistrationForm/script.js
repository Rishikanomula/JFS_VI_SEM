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
document.getElementById("regForm").addEventListener("submit", function(e) {
    e.preventDefault();
    e.preventDefault();

    let selectedSubjects = [];
    let totalFee=0;

    subjects.forEach(sub => {
        if(sub.checked){
            let subjectName = sub.parentElement.innerText.trim();
            selectedSubjects.push(subjectName);
            totalFee += parseInt(sub.value);
        }
    });
    if(selectedSubjects.length === 0){
        alert("Please select at least one subject.");
        return;
    }
    let studentName = document.getElementById("name").value;
    let message =
        "Student Name: " + studentName + "\n\n" +
        "Selected Subjects:\n- " + selectedSubjects.join("\n- ") + "\n\n" +
        "Total Fee: ₹ " + totalFee;
    alert(message);
});