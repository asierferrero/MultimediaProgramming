using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ClickDetect : MonoBehaviour
{
    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;

            if (Physics.Raycast(ray, out hit))
            {
                GameObject obj = hit.collider.gameObject;

                if (obj != null)
                {
                    Renderer rend = obj.GetComponent<Renderer>();

                    // Check if the object has a Renderer component
                    if (rend != null)
                    {
                        rend.material.color = Random.ColorHSV();
                    }
                }
            }
        }
    }
}
