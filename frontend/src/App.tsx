import "./App.css";

import { useCallback, useState } from 'react';
import { useDropzone} from 'react-dropzone';


import FormRow from "./components/FormRow";
import FormLabel from "./components/FormLabel";
import InputText from "./components/InputText";


function App() {
  const handleRequest = async() =>{
    try {
      const response = await fetch('http://localhost:8080/api/hello')
      const data = await response.text(); 
      console.log(data);
      }catch(error){
        console.log(error);
      }

  }


  const onDrop = useCallback((acceptedFiles: Array<File>) => {
    const file = new FileReader;

    file.onload = function() {
      setPreview(file.result);
    }

    file.readAsDataURL(acceptedFiles[0])
  }, [])

  const { acceptedFiles, getRootProps, getInputProps, isDragActive } = useDropzone({
    onDrop
  });

  const [preview, setPreview] = useState<string | ArrayBuffer | null>(null);

  /**
   * handleOnSubmit
   */
  async function handleOnSubmit(e: React.SyntheticEvent) {
    e.preventDefault();
    console.log("bosh");
  }


  return (

      <>
        <h1 className="text-6xl font-black text-center text-slate-900 mb-20">
          Kitty cat identifier
        </h1>
        
        <form id="myForm" name="myForm" className="max-w-md border border-gray-200 rounded p-6 mx-auto" onSubmit={handleOnSubmit}>

          <FormRow className="mb-5">
            <FormLabel htmlFor="image"></FormLabel>
            <div {...getRootProps()}>
              <input {...getInputProps()} />
              {
                isDragActive ?
                  <p>Drop the files here ...</p> :
                  <p>Drag 'n' drop some files here, or click to select files</p>
              }
            </div>
          </FormRow>

          {preview && (
            <p className="mb-5">
              <img src={preview as string} alt="Upload preview" />
            </p>
          )}

          <button>Submit</button>
        </form>

      </>

)}

export default App;