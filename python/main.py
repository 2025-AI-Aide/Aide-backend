from dotenv import load_dotenv
load_dotenv()
from fastapi import FastAPI, UploadFile, File
from ocr import extract_text_from_image
# from gpt_analysis import analyze_contract_with_gpt

app = FastAPI()

@app.post("/file")
async def analyze(file: UploadFile = File(...)):
    contents = await file.read()

    # OCR
    text = extract_text_from_image(contents)

    # GPT 분석
    # result = analyze_contract_with_gpt(text)

    return {
        "text": text,
        "analysis": "result"
    }
