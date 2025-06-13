import os
from openai import OpenAI

client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))

def analyze_contract_with_gpt(text: str) -> str:

    prompt = f"""
    다음은 전세 계약서의 특약사항입니다. 각 문장을 개별적으로 분석해 주세요. 각 문장은 올바른 단어로 이루어져있지 않을 수 있습니다. '|' 는 문자가 아닌 표의 형태일 수 있습니다. 문장에 이상한 문자나 단어가 있다면 문법에 맞게 바꾸어주세요. 문장은 '특약사항'이라는 문구 다음에 등장하는 문장만 분석해주세요. 각 문장에 대해 다음 항목들을 포함하여 출력해 주세요:

    1. 위험도 수준 (1~5 사이의 숫자, 숫자만)
    2. 위험사항 여부 ("예" 또는 "아니오")
    3. 위험사항일 경우, 그 이유를 상세하게 설명 (예: 세입자에게 불리한 조항 등), 위험사항이 아닐경우, 위험하지 않은 이유를 설명

    출력 형식은 다음과 같게 해 주세요:

    문장: [원본 문장]  
    위험도: [1~5 숫자]  
    위험사항 여부: [예/아니오]  
    위험 사유: [해당되는 경우만 작성]

    '문장 1: 현 시설물 상태에서 임대차한다.
    위험도: 3
    위험사항 여부: 예
    위험 사유: 현재 상태로 임대한다는 조항은 추후 시설물 하자에 대한 임대인의 책임을 면제할 수 있어, 세입자에게 불리함.' 
    이 예시 형식을 이용하여 작성해주세요. 

    아래는 특약사항입니다:

    {text}
    """

    response = client.chat.completions.create(
        model="gpt-4",  # 또는 gpt-4
        messages=[
            {"role": "system", "content": "당신은 부동산 계약서를 분석하는 법률 도우미입니다."},
            {"role": "user", "content": prompt}
        ]
    )
    print(response.choices[0].message.content)
    return response.choices[0].message.content
