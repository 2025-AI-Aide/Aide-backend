# from PIL import Image
# import pytesseract
# pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'
# import io


# def extract_text_from_image(image_bytes: bytes) -> str:
#     image = Image.open(io.BytesIO(image_bytes))
    
#     text = pytesseract.image_to_string(image, lang='kor')
#     print(text)
#     return text.strip()
# from PIL import Image
# import pytesseract
# import io
# import cv2
# import numpy as np

# pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'

# def extract_text_from_image(image_bytes: bytes) -> str:
#     # PIL 이미지 열기
#     image = Image.open(io.BytesIO(image_bytes))

#     # PIL -> OpenCV 이미지 변환 (np 배열, BGR 형식)
#     image_cv = cv2.cvtColor(np.array(image), cv2.COLOR_RGB2BGR)

#     # 1. 그레이스케일 변환
#     gray = cv2.cvtColor(image_cv, cv2.COLOR_BGR2GRAY)

#     # 2. 이진화 (Otsu Threshold)
#     _, binary = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

#     # 3. 이미지 확대 (2배)
#     resized = cv2.resize(binary, None, fx=2, fy=2, interpolation=cv2.INTER_LINEAR)

#     # 5. 리사이즈 적용
#     # resized = auto_resize_for_ocr(binary)

#     # (선택) 4. 노이즈 제거 - 필요시 주석 해제
#     # resized = cv2.medianBlur(resized, 3)

#     # Tesseract 설정 (한국어, PSM 6: 단일 블록 텍스트)
#     custom_config = r'--oem 3 --psm 6'

#     # OpenCV 이미지를 다시 PIL 이미지로 변환 (Tesseract가 PIL 이미지 입력 필요)
#     processed_pil = Image.fromarray(resized)

#     # OCR 실행
#     text = pytesseract.image_to_string(processed_pil, lang='kor', config=custom_config)

#     print(text)
#     return text.strip()

from PIL import Image
import pytesseract
import io
import cv2
import numpy as np

# Tesseract 실행 경로 설정 (Windows용)
pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract.exe'

def preprocess_for_ocr(image_cv: np.ndarray, char_height_hint=25, original_char_height=58) -> np.ndarray:
    # 1. 그레이스케일
    gray = cv2.cvtColor(image_cv, cv2.COLOR_BGR2GRAY)

    # 2. 이진화 (Otsu)
    _, binary = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

    # 3. 글자 크기에 맞춰 리사이즈
    scale = char_height_hint / original_char_height  # ex: 25 / 58 ≈ 0.43
    resized = cv2.resize(binary, None, fx=scale, fy=scale, interpolation=cv2.INTER_AREA)

    # 4. 다시 2배 확대 (Tesseract 최적화)
    resized = cv2.resize(resized, None, fx=2, fy=2, interpolation=cv2.INTER_LINEAR)

    return resized

def extract_text_from_image(image_bytes: bytes) -> str:
    # 이미지 로딩
    image = Image.open(io.BytesIO(image_bytes))
    image_cv = cv2.cvtColor(np.array(image), cv2.COLOR_RGB2BGR)

    # OCR 최적화를 위한 전처리
    processed = preprocess_for_ocr(image_cv)

    # (선택) 디버깅용 저장
    # cv2.imwrite("debug_processed.jpg", processed)

    # PIL 변환 후 OCR 실행
    processed_pil = Image.fromarray(processed)
    custom_config = r'--oem 3 --psm 6'  # 필요한 경우 psm 변경 가능

    text = pytesseract.image_to_string(processed_pil, lang='kor', config=custom_config)

    print(text)
    return text.strip()