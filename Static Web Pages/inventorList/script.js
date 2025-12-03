document.getElementById("languageSelect").addEventListener("change", function () {
    const selected = this.value;
    const infoSection = document.getElementById("infoSection");
    const img = document.getElementById("inventorImg");
    const infoBox = document.getElementById("inventorInfo");

    if (selected === "") {
        infoSection.style.display = "none";
        return;
    }

    let data = {
        java: {
            img: "images/gosling.jpg",
            info: "<h2>James Gosling</h2><p>Inventor of Java (1995). Known as the 'Father of Java'.</p>"
        },
        c: {
            img: "images/ritchie.jpeg",
            info: "<h2>Dennis Ritchie</h2><p>Created the C language and co-developed Unix.</p>"
        },
        python: {
            img: "images/rossum.jpg",
            info: "<h2>Guido van Rossum</h2><p>Creator of Python (1991), known for clean and readable syntax.</p>"
        },
        cpp: {
            img: "images/bjarne.jpg",
            info: "<h2>Bjarne Stroustrup</h2><p>Inventor of C++ (1985), bringing OOP to C.</p>"
        },
        javascript: {
            img: "images/eich.jpg",
            info: "<h2>Brendan Eich</h2><p>Created JavaScript in just 10 days while at Netscape (1995).</p>"
        },
        php: {
            img: "images/lerdorf.jpeg",
            info: "<h2>Rasmus Lerdorf</h2><p>Creator of PHP (1995), originally built as a simple CGI toolset.</p>"
        },
        ruby: {
            img: "images/matsumoto.jpeg",
            info: "<h2>Yukihiro Matsumoto (Matz)</h2><p>Creator of Ruby (1995), designed for developer happiness.</p>"
        },
        csharp: {
            img: "images/hejlsberg.jpeg",
            info: "<h2>Anders Hejlsberg</h2><p>Lead architect of C# at Microsoft, also known for Turbo Pascal.</p>"
        },
        cobol: {
            img: "images/hopper.jpeg",
            info: "<h2>Grace Hopper</h2><p>Pioneer of COBOL and early computer programming, known as 'Amazing Grace'.</p>"
        },
        lisp: {
            img: "images/mccarthy.jpg",
            info: "<h2>John McCarthy</h2><p>Inventor of Lisp (1958) and one of the founding fathers of Artificial Intelligence.</p>"
        }
    };

    img.src = data[selected].img;  
    infoBox.innerHTML = data[selected].info;

    // Reset to circular for all images
    img.classList.remove("square");

    // Make only James Gosling's image square
    if (selected === "java") {
        img.classList.add("square");
    }

    infoSection.style.display = "flex";

});
