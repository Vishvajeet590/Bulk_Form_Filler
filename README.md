# Bulk Form Filler
This small application is product of my laziness, to avoid filling forms in bulk.

Steps to use this 

1. Clone this repo.
2. Replace the Sample.pdf in root directory with your pdf and rename it again to Sample.pdf
3. Export your data as a csv format and resplace it with data.csv in the root directory of application.
4. Open the bash/cmd/powershell at the root dir of the application that is ../Bulk_Form_Filler Run the following. This will open the pdf.
```console
java -jar pdfbox-app-2.0.26.jar PDFDebugger Sample.pdf
```
5. Move the cursor to the position where you want to add the text note down the x & y coordinates on the 1st line of your csv and repeat it for other fields. Note - all the coordinates should be on the first line only and should be equal to the columns in CSV file. 

#### Sample.pdf
<img width="388" alt="image" src="https://user-images.githubusercontent.com/42716731/168443527-3122b742-aa3f-4b90-8e93-05cc1dfa6eb3.png">

#### Example CSV : data.csv
|157 160|197 150|
|-------|-------|
|John   | ABC   |
|Doe    | XYZ   |


6. Last step is to run the main class. This will generate the filled pdfs in folder named exports.
