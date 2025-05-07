import os
from openai import OpenAI

# client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

# def analyze_contract_with_gpt(text: str) -> str:
#     response = client.chat.completions.create(
#         model="gpt-3.5-turbo",  # 또는 gpt-4
#         messages=[
#             {"role": "system", "content": "당신은 부동산 계약서를 분석하는 법률 도우미입니다."},
#             {"role": "user", "content": text}
#         ]
#     )
#     return response.choices[0].message.content
