// Programming language inventor data
const data = {
    java: {
        img: "images/gosling.jpg",
        info: "<h2>James Gosling</h2><p>Inventor of Java (1995). Known as the 'Father of Java'.</p>"
    },
    c: {
        img: "images/ritchie.jpeg",
        info: "<h2>Dennis Ritchie</h2><p>Creator of the C language and co-developer of Unix.</p>"
    },
    python: {
        img: "images/rossum.jpg",
        info: "<h2>Guido van Rossum</h2><p>Creator of Python (1991), known for clean and readable syntax.</p>"
    },
    cpp: {
        img: "images/bjarne.jpg",
        info: "<h2>Bjarne Stroustrup</h2><p>Inventor of C++ (1985), introducing OOP to C.</p>"
    },
    javascript: {
        img: "images/eich.jpg",
        info: "<h2>Brendan Eich</h2><p>Created JavaScript in just 10 days (1995) at Netscape.</p>"
    },
    php: {
        img: "images/lerdorf.jpeg",
        info: "<h2>Rasmus Lerdorf</h2><p>Creator of PHP (1995), originally built as a set of CGI scripts.</p>"
    },
    ruby: {
        img: "images/matsumoto.jpeg",
        info: "<h2>Yukihiro Matsumoto (Matz)</h2><p>Creator of Ruby (1995), focused on developer happiness.</p>"
    },
    csharp: {
        img: "images/hejlsberg.jpeg",
        info: "<h2>Anders Hejlsberg</h2><p>Lead architect of C#. Also created Turbo Pascal.</p>"
    },
    cobol: {
        img: "images/hopper.jpeg",
        info: "<h2>Grace Hopper</h2><p>Pioneer of COBOL and early programming. Known as 'Amazing Grace'.</p>"
    },
    lisp: {
        img: "images/mccarthy.jpg",
        info: "<h2>John McCarthy</h2><p>Inventor of Lisp (1958) and a founding father of AI.</p>"
    }
};

// Handle dropdown change
document.getElementById("languageSelect").addEventListener("change", function () {
    const selected = this.value;
    const infoSection = document.getElementById("infoSection");
    const img = document.getElementById("inventorImg");
    const infoBox = document.getElementById("inventorInfo");

    // Hide section if nothing selected
    if (selected === "") {
        infoSection.style.display = "none";
        return;
    }

    // Update image + info
    img.src = data[selected].img;
    infoBox.innerHTML = data[selected].info;

    // Remove previous special styling
    img.classList.remove("square");
    img.classList.remove("glow");

    // Apply special square + glow only to James Gosling
    if (selected === "java") {
        img.classList.add("square");
        img.classList.add("glow-frame");
    }

    // Show info section
    infoSection.style.display = "flex";
});
