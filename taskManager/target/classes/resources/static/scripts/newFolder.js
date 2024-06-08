document.getElementById('newFolderForm').addEventListener('submit', function (event) {
    event.preventDefault();

    let folderInput = document.getElementById('newFolderInput');
    const folderName = folderInput.value.trim();

    if(folderName) {
        const folderRow = document.createElement('div');
        folderRow.classList.add('row');
        const folderIcon = document.createElement('img');
        folderIcon.classList.add('categoryIcon');
        folderIcon.src = '../images/folder.svg';
        const folderTitle = document.createElement('h3');
        folderTitle.textContent = folderName;

        //Apply attributes to the row & reset input field.
        folderRow.appendChild(folderIcon);
        folderRow.appendChild(folderTitle);
        document.getElementById('folders').appendChild(folderRow);
        folderInput.value = '';
    }
});