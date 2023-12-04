using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class behaviorScript : MonoBehaviour
{
    public float speed = 5f; // Adjust the speed of the movement

    private Vector3 startPoint;
    private Vector3 endPoint;
    private Vector3 nextPoint;
    private int direction = 1; // 1 for forward, -1 for backward

    // Start is called before the first frame update
    void Start()
    {
        startPoint = transform.position;
        endPoint = new Vector3(startPoint.x + 5f, startPoint.y, startPoint.z); // Adjust the distance of the movement
        nextPoint = endPoint;
    }

    // Update is called once per frame
    void Update()
    {
        transform.position = Vector3.MoveTowards(transform.position, nextPoint, speed * Time.deltaTime);

        if (transform.position == nextPoint)
        {
            // Change color when direction changes
            GetComponent<Renderer>().material.color = Random.ColorHSV();

            // Change direction and set the next point
            direction *= -1;

            if (direction == 1)
            {
                nextPoint = endPoint;
            }
            else
            {
                // Change the axis here if working in pairs
                nextPoint = new Vector3(startPoint.x, startPoint.y, startPoint.z);
            }
        }
    }
}
