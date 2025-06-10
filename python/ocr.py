# from PIL import Image
# import pytesseract
# pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'
# import io


# def extract_text_from_image(image_bytes: bytes) -> str:
#     image = Image.open(io.BytesIO(image_bytes))
    
#     text = pytesseract.image_to_string(image, lang='kor')
#     print(text)
#     return text.strip()
from PIL import Image
import pytesseract
import io
import cv2
import numpy as np

pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'

def extract_text_from_image(image_bytes: bytes) -> str:
    # PIL 이미지 열기
    image = Image.open(io.BytesIO(image_bytes))

    # PIL -> OpenCV 이미지 변환 (np 배열, BGR 형식)
    image_cv = cv2.cvtColor(np.array(image), cv2.COLOR_RGB2BGR)

    # 1. 그레이스케일 변환
    gray = cv2.cvtColor(image_cv, cv2.COLOR_BGR2GRAY)

    # 2. 이진화 (Otsu Threshold)
    _, binary = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

    # 3. 이미지 확대 (2배)
    resized = cv2.resize(binary, None, fx=2, fy=2, interpolation=cv2.INTER_LINEAR)

    # (선택) 4. 노이즈 제거 - 필요시 주석 해제
    # resized = cv2.medianBlur(resized, 3)

    # Tesseract 설정 (한국어, PSM 6: 단일 블록 텍스트)
    custom_config = r'--oem 3 --psm 6'

    # OpenCV 이미지를 다시 PIL 이미지로 변환 (Tesseract가 PIL 이미지 입력 필요)
    processed_pil = Image.fromarray(resized)

    # OCR 실행
    text = pytesseract.image_to_string(processed_pil, lang='kor', config=custom_config)

    print(text)
    return text.strip()