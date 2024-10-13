import "./App.css";

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
  return (
    <>
      <div>
        <h1>Kitty cat identifier</h1>
        <button onClick={handleRequest}>Put hello in console</button>
      </div>
    </>
  );
}

export default App;
