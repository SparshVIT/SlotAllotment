from flask import Flask, request, jsonify
import pickle

app = Flask(__name__)


@app.route('/')
def home():
    return "Hello world"
@app.route('/predict', methods=['POST'])
def predict():
    # Get the subject name from the request
    subject = request.values.get('subject')
    if not subject:
    # Return an error message as a JSON response
        return jsonify({"error": "Subject name is required."})

    # Load the model and the vectorizer from the pickle files
    model = pickle.load(open("NModel.pkl", "rb"))
    vectorizer = pickle.load(open("vectorizer.pkl", "rb"))

    # Vectorize the subject name using TF-IDF
    subject = vectorizer.transform([subject])

    # Predict the domain using the model
    domain = model.predict(subject)[0]

    # Return the domain as a JSON response
    return jsonify({"domain":str(domain)})

# Run the app
if __name__ == "__main__":
    app.run(debug=True)

